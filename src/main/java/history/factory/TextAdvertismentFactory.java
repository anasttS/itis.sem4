package history.factory;

import history.models.Advertisment;
import history.models.TextAdvertisment;

public class TextAdvertismentFactory implements AdvertismentFactory {
    private static TextAdvertismentFactory textAdFactory;

    public static TextAdvertismentFactory getInstance() {
        if (textAdFactory == null) {
            textAdFactory = new TextAdvertismentFactory();
        }
        return textAdFactory;
    }

    @Override
    public Advertisment createAdvertisment(String url) {
        return new TextAdvertisment(url);
    }
}
