public class NBody {

    public static double readRadius(String planetsTxtPath) {
        In in = new In(planetsTxtPath);
        int number_of_planet = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    public static Planet[] readPlanets(String planetsTxtPath) {
        In in = new In(planetsTxtPath);

        int number_of_planet = in.readInt();
        Planet[] actualOutput = new Planet[number_of_planet];
        double radius = in.readDouble();
        for (int i = 0; i < actualOutput.length; i++) {
            actualOutput[i] = new Planet(in.readDouble(), in.readDouble()
                    , in.readDouble(), in.readDouble()
                    , in.readDouble(), in.readString());
        }
        return actualOutput;
    }

    public static void main(String[] args) {
        Double T = Double.parseDouble(args[0]);
        Double dt = Double.parseDouble(args[1]);
        Planet[] planets = NBody.readPlanets(args[2]);
        double radius = readRadius(args[2]);

        StdDraw.enableDoubleBuffering();
        String imageToDraw = "images/starfield.jpg";
        StdDraw.setScale(-radius, radius);
        StdDraw.clear();
        //StdDraw.picture(0, 0, imageToDraw);
        for (int tv = 0; tv < T; tv+=dt){
            Double[] xForces = new Double[planets.length];
            Double[] yForces  = new Double[planets.length];
            for (int i = 0; i < planets.length; i+=1) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
                planets[i].update(dt, xForces[i], yForces[i]);
            }
                StdDraw.picture(0, 0, imageToDraw);
            for (int i = 0; i < planets.length; i+=1) {
                planets[i].draw();
            }
                StdDraw.show();
                StdDraw.pause(10);
        }

        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
    }
}