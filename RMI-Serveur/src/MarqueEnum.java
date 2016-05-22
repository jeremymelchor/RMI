public enum MarqueEnum {

    AUDI("audi"),
    BMW("BMW"),
    FIAT("fiat"),
    RENAULT("renault"),
    PEUGEOT("peugeot"),
    CITROEN("citroen"),
    PORSCHE("porsche"),
    FERRARI("ferrari");

    private String marque;

    MarqueEnum(String marque) {
        this.marque = marque;
    }

    public String getMarque() {
        return marque;
    }
}
