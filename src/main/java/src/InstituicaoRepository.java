package src;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InstituicaoRepository extends JpaRepository<Instituicao, Integer> {
    java.util.List<Instituicao> findAllByOrderByNomeAsc();
    boolean existsByNomeIgnoreCase(String nome);
}
