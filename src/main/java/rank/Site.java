package rank;


public class Site implements Comparable<Site> {
    private String name;
    private double rank;
    public Site(String n){
        if(n.isEmpty()){
            throw new IllegalArgumentException("El nombre de la pagina no puede estar vacio");
        }else{
            this.name=n;
            this.rank=0;
        }
    }

    public String getName() {
        return name;
    }

    public double getRank() {
        return rank;
    }
    public void addRank(double r){
        this.rank+=r;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Site site = (Site) o;
        return this.name.equalsIgnoreCase(site.name);
    }

    @Override
    public int hashCode() {
        return (this.name.toLowerCase()).hashCode();
    }

    @Override
    public String toString() {
        return name+"("+rank+")";
    }

    @Override
    public int compareTo(Site o) {
        return this.name.compareToIgnoreCase(o.name);
    }
}
