package src;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
public class AlunoService {
    private final AlunoRepository alunoRepository;
    private final InstituicaoRepository instituicaoRepository;
    private final PasswordEncoder passwordEncoder;

    public AlunoService(
            AlunoRepository alunoRepository,
            InstituicaoRepository instituicaoRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.alunoRepository = alunoRepository;
        this.instituicaoRepository = instituicaoRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional(readOnly = true)
    public List<AlunoResponse> listar() {
        return alunoRepository.findAllByOrderByNomeAsc().stream().map(AlunoResponse::from).toList();
    }

    @Transactional(readOnly = true)
    public AlunoResponse buscar(int id) {
        return AlunoResponse.from(encontrar(id));
    }

    public AlunoResponse criar(AlunoRequest request) {
        if (request.senha() == null || request.senha().isBlank()) {
            throw new IllegalArgumentException("A senha é obrigatória no cadastro e deve ter pelo menos 8 caracteres.");
        }
        Aluno aluno = new Aluno();
        aplicar(aluno, request);
        aluno.setSenhaHash(passwordEncoder.encode(request.senha()));
        return AlunoResponse.from(alunoRepository.save(aluno));
    }

    public AlunoResponse atualizar(int id, AlunoRequest request) {
        Aluno aluno = encontrar(id);
        aplicar(aluno, request);
        if (request.senha() != null && !request.senha().isBlank()) {
            aluno.setSenhaHash(passwordEncoder.encode(request.senha()));
        }
        return AlunoResponse.from(alunoRepository.save(aluno));
    }

    public void excluir(int id) {
        alunoRepository.delete(encontrar(id));
    }

    private Aluno encontrar(int id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado."));
    }

    private void aplicar(Aluno aluno, AlunoRequest request) {
        Instituicao instituicao = instituicaoRepository.findById(request.instituicaoId())
                .orElseThrow(() -> new IllegalArgumentException("Selecione uma instituição cadastrada."));
        aluno.setNome(request.nome().trim());
        aluno.setEmail(request.email().trim().toLowerCase());
        aluno.setLogin(request.login().trim());
        aluno.setCpf(request.cpf().replaceAll("\\D", ""));
        aluno.setRg(request.rg().trim());
        aluno.setEndereco(request.endereco().trim());
        aluno.setCurso(request.curso().trim());
        aluno.setInstituicao(instituicao);
    }
}
