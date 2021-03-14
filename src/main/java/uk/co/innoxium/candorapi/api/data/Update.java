package uk.co.innoxium.candorapi.api.data;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@Entity
public class Update {

    @Id
    @GeneratedValue
    private Long id;

    // These will be put together to create a path of "https://innoxium.co.uk/api/updates/updateVersion/updateFilePath"
    private String updateVersion;
    private String updateFilePath;

    public Update() {

    }

    public Update(String version, String filePath) {

        this.updateVersion = version;
        this.updateFilePath = filePath;
    }
}
