package src;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
public class EmpresaService {
    private final EmpresaRepository empresaRepository;
    private final PasswordEncoder passwordEncoder;

    public EmpresaService(EmpresaRepository empresaRepository, PasswordEncoder passwordEncoder) {
        this.empresaRepository = empresaRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional(readOnly = true)
    public List<EmpresaResponse> listar() {
        return empresaRepository.findAllByOrderByNomeAsc().stream().map(EmpresaResponse::from).toList();
    }

    @Transactional(readOnly = true)
    public EmpresaResponse buscar(int id) {
        return EmpresaResponse.from(encontrar(id));
    }

    public EmpresaResponse criar(EmpresaRequest request) {
        if (request.senha() == null || request.senha().isBlank()) {
            throw new IllegalArgumentException("A senha é obrigatória no cadastro e deve ter pelo menos 8 caracteres.");
        }
        EmpresaParceira empresa = new EmpresaParceira();
        aplicar(empresa, request);
        empresa.setSenhaHash(passwordEncoder.encode(request.senha()));
        return EmpresaResponse.from(empresaRepository.save(empresa));
    }

    public EmpresaResponse atualizar(int id, EmpresaRequest request) {
        EmpresaParceira empresa = encontrar(id);
        aplicar(empresa, request);
        if (request.senha() != null && !request.senha().isBlank()) {
            empresa.setSenhaHash(passwordEncoder.encode(request.senha()));
        }
        return EmpresaResponse.from(empresaRepository.save(empresa));
    }

    public void excluir(int id) {
        empresaRepository.delete(encontrar(id));
    }

    private EmpresaParceira encontrar(int id) {
        return empresaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Empresa não encontrada."));
    }

    private void aplicar(EmpresaParceira empresa, EmpresaRequest request) {
        empresa.setNome(request.nome().trim());
        empresa.setEmail(request.email().trim().toLowerCase());
        empresa.setLogin(request.login().trim());
        empresa.setCnpj(request.cnpj().replaceAll("\\D", ""));
    }
}
