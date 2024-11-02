public class Vector2 {
    double x;
    double y;
    public Vector2(double _x, double _y){
        x=_x;
        y=_y;
    }
    public Vector2(){
        x=0.0;
        y=0.0;
    }
    public double getDist(){
        return Math.sqrt(x*x+y*y);
    }
    //math classes
    public Vector2 add(Vector2 b){
        return new Vector2(x+b.x,y+b.y);
    }
    public Vector2 subtract(Vector2 b){
        return new Vector2(x-b.x,y-b.y);
    }
    public Vector2 multiply(Vector2 b){
        return new Vector2(x*b.x,y*b.y);
    }
    public Vector2 divide(Vector2 b){
        return new Vector2(x/b.x,y/b.y);
    }
    public Vector2 multiply(double b){
        return new Vector2(x*b,y*b);
    }
    public Vector2 divide(double b){
        return new Vector2(x/b,y/b);
    }
    public Vector2 normalize(){
        return this.divide(this.getDist());
    }
}
