package uk.co.innoxium.candorapi.api.endpoint.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.co.innoxium.candorapi.api.data.Update;

public interface UpdateRepository extends JpaRepository<Update, Long> {
}
