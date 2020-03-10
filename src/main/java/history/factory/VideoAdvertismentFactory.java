package history.factory;

import history.models.Advertisment;
import history.models.VideoAdvertisment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VideoAdvertismentFactory implements  AdvertismentFactory {
    private boolean isWatched;
    private String adUrl;

    private static VideoAdvertismentFactory videoAdvertismentFactory;

    public static VideoAdvertismentFactory getInstance() {
        if (videoAdvertismentFactory == null) {
            videoAdvertismentFactory = new VideoAdvertismentFactory();
        }
        return videoAdvertismentFactory;
    }

    @Override
    public Advertisment createAdvertisment(String url) {
        return new VideoAdvertisment(isWatched, adUrl);
    }
}