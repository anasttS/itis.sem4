package history.models;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VideoAdvertisment implements Advertisment {
    private boolean isWatched;
    private String adUrl;
}
