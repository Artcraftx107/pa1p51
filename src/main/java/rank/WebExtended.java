package rank;

public class WebExtended extends Web{
    @Override
    protected void addSiteWithName(String n) {
        SiteExtended xd = new SiteExtended(n);
        addSite(xd);
    }

    @Override
    protected void distribute(Site site, double prize) {
        SiteExtended siteExtended = (SiteExtended) site;
        if(siteExtended.isValid()){
            super.distribute(siteExtended, prize);
        }
    }

    public void switchSiteWithName(String name){
        for(Site site : sites){
            if(site.getName().equalsIgnoreCase(name)){
                SiteExtended cs2 = (SiteExtended) site;
                if(cs2.isValid()){
                    cs2.setValid(false);
                }else{
                    cs2.setValid(true);
                }
            }
        }
    }
}
