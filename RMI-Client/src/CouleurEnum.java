public enum CouleurEnum {

    ROUGE("rouge"),
    BLEU("bleu"),
    VERT("vert"),
    JAUNE("jaune"),
    GRIS("gris"),
    NOIR("noir"),
    BLANC("blanc"),
    ORANGE("orange");

    private String couleur;

    CouleurEnum(String couleur) {
        this.couleur = couleur;
    }

    public String getCouleur() {
        return couleur;
    }
}
