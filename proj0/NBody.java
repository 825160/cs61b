public class NBody{
    public static double readRadius(String address){
        In in=new In(address);
        in.readInt();
        return in.readDouble();
    }

    public static Planet[] readPlanets(String address){
        In in=new In(address);
        int num=in.readInt();
        Planet[] planets=new Planet[num];
        in.readDouble();
        for(int i=0;i<planets.length;i++){
            planets[i]=new Planet(in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readString());
        }
        return planets;
    }

    public static void main(String[] args){
        double T=parseDouble(args[0]);
        double dt=parseDouble(args[1]);
        String filename=args[2];
        Planet[] planets=readPlanets(filename);
        double universe_radius=readRadius(filename);
    }
}