package challenge;

public enum CMD {
	MENU(0),
    INSERT(1),
    SETBOOKS(2),    
    RETRIEVE(3),
    ANALYSIS(4),
    EXIT(5),
    ;

    private final int label;

    CMD(int label) {
        this.label = label;
    }

    public int label() {
        return label;
    }
}