package rank;

import java.util.*;

public class Web {
    private Set<Link> links;
    protected Set<Site> sites;
    private double THRESHOLD;
    private Random alea;

    public Web(){
        this.links=new HashSet<>();
        this.sites=new HashSet<>();
    }

    protected void addSite(Site site){
        sites.add(site);
    }

    protected void addSiteWithName(String n){
        Site site = new Site(n);
        sites.add(site);
    }

    public void addLink(String dataLink){
        String[] data = dataLink.split("->");
        String name = data[0];
        String bruh = data[1];
        if(name.isEmpty()||bruh.isEmpty()){
            throw new IllegalArgumentException("El dataLink especificado ("+dataLink+") ha dado un fallo a la hora de dividirlo en partes");
        }else{
            Link xd = new Link(name, bruh);
            addSiteWithName(name);
            addSiteWithName(bruh);
            links.add(xd);
        }
    }

    public Site getSite(String name) {
        for (Site site : sites) {
            if (site.getName().equalsIgnoreCase(name)) {
                return site;
            }
        }
        throw new NoSuchElementException("No existe la página con nombre: " + name);
    }

    public Set<String> getNames(){
        Set<String> xdd = new TreeSet<>();
        for(Site site : sites){
            xdd.add(site.getName());
        }
        return xdd;
    }

    private Set<Site> getSitesLinkedFrom(Site site){
        Set<Site> linkedLinks = new HashSet<>();
        for(Link link : links){
            if(link.getOrigin().equalsIgnoreCase(site.getName())){
                for(Site site1 : sites){
                    if(site.getName().equalsIgnoreCase(link.getLinked())){
                        linkedLinks.add(site);
                        break;
                    }
                }
            }
        }
        return linkedLinks;
    }

    protected void distribute(Site site, double prize){
        if(!(prize<THRESHOLD)){
            double halfPrize = prize/2;
            site.addRank(halfPrize);
            Set<Site> aux = getSitesLinkedFrom(site);
            if(!aux.isEmpty()){
                double rest = halfPrize/(2*aux.size());
                for(Site site1 : aux){
                    site1.addRank(rest);
                }
            }
        }
    }

    public void click(String name){
        try{
            distribute(getSite(name), 1);
        }catch (NoSuchElementException ignore){

        }
    }

    public void simulateClick(int numClick){
        if(!sites.isEmpty()){
            alea=new Random(1);
            List<Site> killerQueen= new ArrayList<>(sites);
            for(int i = 0; i<numClick; i++){
                int randomIndex = alea.nextInt(killerQueen.size());
                Site randomSiteVeryCool = killerQueen.get(randomIndex);
                click(randomSiteVeryCool.getName());
            }
        }
    }

    public SortedSet<Site> getSitesByName(){
        SortedSet<Site> awp = new TreeSet<>(sites);
        return awp;
    }

    public SortedSet<Site> getSitesByRank(){
        SortedSet<Site> sortedSetByRank = new TreeSet<>(new Comparator<Site>() {
            @Override
            public int compare(Site o1, Site o2) {
                // First compare by rank (in descending order)
                int rankComparison = Double.compare(o2.getRank(), o1.getRank());
                if (rankComparison != 0) {
                    return rankComparison;
                } else {
                    // If ranks are equal, compare by name (in ascending order)
                    return o1.getName().compareToIgnoreCase(o2.getName());
                }
            }
        });
        sortedSetByRank.addAll(sites);
        return sortedSetByRank;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(sites).append(", ").append(links);
        return "Web("+sb+")";
    }
}
