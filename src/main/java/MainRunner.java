public class MainRunner {
    public static void main(String[] args) {
        String information = "I have the type: %s";

        Screen screenMonitor = (Screen) new Monitor(32, 29, "3:2", 120);
        System.out.println(String.format(information, screenMonitor.getClass().getName()));

        Screen screenTelevision = (Screen) new Television(72, 60, "16:9", "OLED");
        System.out.println(String.format(information, screenTelevision.getClass().getName()));
    }
}

class Screen {
    private int width;
    private int length;
    private String aspectRatio;

    public Screen(int width, int length, String aspectRatio) {
        this.width = width;
        this.length = length;
        this.aspectRatio = aspectRatio;
    }

    @Override
    public String toString() {
        return String.format("I am a %s. I am %s inches by %s inches. My aspect ration is %s.",
                this.getClass().getName(),
                width, length, aspectRatio);
    }
}

class Monitor extends Screen {
    private int refreshRate;

    public Monitor(int width, int length, String aspectRatio, int refreshRate) {
        super(width, length, aspectRatio);
        this.refreshRate = refreshRate;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" I have a %s Hz refresh rate.", refreshRate);
    }
}

class Television extends Screen {
    private String displayTechnology;

    public Television(int width, int length, String aspectRatio, String displayTechnology) {
        super(width, length, aspectRatio);
        this.displayTechnology = displayTechnology;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" I use %s technology.", displayTechnology);
    }
}