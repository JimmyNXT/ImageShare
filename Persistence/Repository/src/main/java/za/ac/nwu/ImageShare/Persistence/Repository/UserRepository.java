package za.ac.nwu.ImageShare.Persistence.Repository;

import org.graalvm.compiler.lir.LIRInstruction;
import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.nwu.ImageShare.Domain.Persistence.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
