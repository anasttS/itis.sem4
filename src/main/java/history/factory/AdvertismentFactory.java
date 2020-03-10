package history.factory;

import history.models.Advertisment;

public interface AdvertismentFactory {
    Advertisment createAdvertisment(String url);
}