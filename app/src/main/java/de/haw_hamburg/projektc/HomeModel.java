package de.haw_hamburg.projektc;

public class HomeModel {
    String moduleName;
    int image;

    public HomeModel(String moduleName, int image) {
        this.moduleName = moduleName;
        this.image = image;
    }

    public String getModuleName() {
        return moduleName;
    }

    public int getImage() {
        return image;
    }
}
