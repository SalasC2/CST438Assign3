package CST438Assign3.domain;

public class CityInfo {
    
    public long ID;
    public String name;
    public String countryCode;
    public String countryName;
    public String district;
    public int population;
    public double temp;

   public CityInfo() {}
   
   public CityInfo(long ID, String name, String countryCode, String countryName, String district, int population,
       double temp) { 
       this.ID = ID;
       this.name = name;
       this.countryCode = countryCode;
       this.countryName = countryName;
       this.district = district;
       this.population = population;
       this.temp = temp;
   }
   
public long getID() {
       return ID;
   }

   public void setID(long ID) {
       this.ID = ID;
   }

   public String getName() {
       return name;
   }

   public void setName(String name) {
       this.name = name;
   }

   public String getCountryCode() {
       return countryCode;
   }

   public void setCountryCode(String countryCode) {
       this.countryCode = countryCode;
   }

   public String getCountryName() {
       return countryName;
   }

   public void setCountryName(String countryName) {
       this.countryName = countryName;
   }

   public String getDistrict() {
       return district;
   }

   public void setDistrict(String district) {
       this.district = district;
   }

   public int getPopulation() {
       return population;
   }

   public void setPopulation(int population) {
       this.population = population;
   }

   public double getTemp() {
       return temp;
   }

   public void setTemp(double temp) {
       this.temp = temp;
   }
   
   @Override
   public String toString() {
       return "CityInfo [id=" + ID + ", name=" + name + ", countryCode=" + countryCode + ", countryName=" + countryName
               + ", district=" + district + ", population=" + population + ", temp=" + temp + "]";
   }
   
   
   
   

}
