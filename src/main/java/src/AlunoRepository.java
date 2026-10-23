package src;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
    java.util.List<Aluno> findAllByOrderByNomeAsc();
}
