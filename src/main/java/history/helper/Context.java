package history.helper;


import history.models.Browser;

public class Context {
    private static Browser browser;

    public static Browser getBrowser() {
        return browser;
    }

    public static void setBrowser(Browser browser) {
        Context.browser = browser;
    }
}
