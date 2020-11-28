import java.util.function.DoubleBinaryOperator;

public class Planet {
    public double xxPos;//Its current x position
    public double yyPos;//Its current y position
    public double xxVel;//Its current velocity in the x direction
    public double yyVel;//Its current velocity in the y direction
    public double mass;//Its mass
    public String imgFileName;//The name of the file that corresponds to the image
    public final Double Gravity = 6.67E-11;
    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }
    public Planet(Planet p){
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }
    public double calcDistance(Planet p2){
        Double dis;
        Double xxsquare = (this.xxPos - p2.xxPos) * (this.xxPos - p2.xxPos);
        Double yysquare = (this.yyPos - p2.yyPos) * (this.yyPos - p2.yyPos);
        dis = Math.sqrt(xxsquare + yysquare);
        return dis;
    }
    public double calcForceExertedBy(Planet p2){
        Double dis = this.calcDistance(p2);
        return Gravity * this.mass * p2.mass / dis / dis;
    }

    public double calcForceExertedByX (Planet p2){
        Double dis = this.calcDistance(p2);
        Double Force = this.calcForceExertedBy(p2);
        return (p2.xxPos - this.xxPos)/dis * Force;
    }
    public double calcForceExertedByY (Planet p2){
        Double dis = this.calcDistance(p2);
        Double Force = this.calcForceExertedBy(p2);
        return (p2.yyPos - this.yyPos)/dis * Force;
    }
    public double calcNetForceExertedByX (Planet[] Ps){
        Double dis_x = 0.0;
        //this = Ps[0];
        for (Planet p:Ps){
            if (this.equals(p)){
                continue;
            }
            dis_x += calcForceExertedByX(p);
        }
        return dis_x;
    }
    public double calcNetForceExertedByY (Planet[] Ps){
        Double dis_y = 0.0;
        //this = Ps[0];
        for (Planet p:Ps){
            if (this.equals(p)){
                continue;
            }
            dis_y += calcForceExertedByY(p);
        }
        return dis_y;
    }
    public void update (double dt, double fX, double fY){
        double a_net_x = fX / mass;
        double a_net_y = fY / mass;
        xxVel += dt * a_net_x;
        yyVel += dt * a_net_y;
        xxPos += dt * xxVel;
        yyPos += dt * yyVel;
    }
    public void draw (){
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }
}
