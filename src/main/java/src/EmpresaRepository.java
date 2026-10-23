package src;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<EmpresaParceira, Integer> {
    java.util.List<EmpresaParceira> findAllByOrderByNomeAsc();
}
