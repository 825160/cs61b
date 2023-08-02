public class Planet{
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public static final double g=6.67e-11;
    
    public Planet(double xP,double yP,double xV,double yV,double m,String img){
        xxPos=xP;
        yyPos=yP;
        xxVel=xV;
        yyVel=yV;
        mass=m;
        imgFileName=img;
    }
    public Planet(Planet p){
        xxPos=p.xxPos;
        yyPos=p.yyPos;
        xxVel=p.xxVel;
        yyVel=p.yyVel;
        mass=p.mass;
        imgFileName=p.imgFileName;
    }

    public double calcDistance(Planet p){
        return Math.sqrt((xxPos-p.xxPos)*(xxPos-p.xxPos)+(yyPos-p.yyPos)*(yyPos-p.yyPos));
    }

    public double calcForceExertedBy(Planet p){
        return g*mass*p.mass/this.calcDistance(p)/this.calcDistance(p);
    }

    public double calcNetForceExertedByX(Planet[] allPlanets){
        double forceExertedByx=0;
        for(int i=0;i<allPlanets.length;i++){
            Planet currentplanet=allPlanets[i];
            if(!equals(currentplanet)){
                forceExertedByx+=calcForceExertedBy(currentplanet)*(currentplanet.xxPos-xxPos)/calcDistance(currentplanet);
            }
        }
        return forceExertedByx;
    }

    public double calcNetForceExertedByY(Planet[] allPlanets){
        double forceExertedByy=0;
        for(int i=0;i<allPlanets.length;i++){
            Planet currentplanet=allPlanets[i];
            if(!equals(currentplanet)){
                forceExertedByy+=calcForceExertedBy(currentplanet)*(currentplanet.yyPos-yyPos)/calcDistance(currentplanet);
            }
        }
        return forceExertedByy;
    }

    public void update(double dt,double fx,double fy){
        double ax=fx/mass;
        double ay=fy/mass;
        xxVel+=ax*dt;
        yyVel+=ay*dt;
        xxPos+=xxVel*dt;
        yyPos+=yyVel*dt;
    }
}