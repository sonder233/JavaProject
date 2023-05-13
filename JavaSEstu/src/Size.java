public enum Size {
    SMALL("S"),MEDIUM("M"),LARGE("L");
    private Size(String abbreviation){
        this.abbreviation = abbreviation;
    }
    public String getAbbreviation(){
        return abbreviation;
    }
    private String abbreviation;
}
