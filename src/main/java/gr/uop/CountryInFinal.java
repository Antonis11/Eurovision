package gr.uop;

public class CountryInFinal {
    private String name;
    private int totalPoints;

    public CountryInFinal(String name, int totalPoints) {
        this.name = name;
        this.totalPoints = totalPoints;
    }

    public int compareTo(CountryInFinal c) {
        return c.totalPoints - this.totalPoints;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        if (obj instanceof CountryInFinal == false) {
            return false;
        }

        CountryInFinal objBigInt = (CountryInFinal) obj;

        if (this.name.equals(objBigInt.name)) {
            return true;
        } else {
            return false;
        }
    }
}
