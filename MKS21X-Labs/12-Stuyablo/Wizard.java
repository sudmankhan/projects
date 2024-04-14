public class Wizard extends Adventurer {
    private int mana;
    private String warcry;
    private int manaMax;

    public Wizard(){
	     this("Megumin");
    }

    public Wizard(String name){
	     this(name,"aaaa!", 18);
    }

    public Wizard(String name, String warcry, int mana){
      super(name,30+(int)(Math.random()*10));
      setWarcry(warcry);
      setMana(mana);
      manaMax = mana;
    }

    //warrior methods

    public String attack(Damageable other){
    	  int damage = (int)(Math.random()*10)+1;
  	    other.applyDamage(damage);
  	    setMana(getMana() + 10);
  	    return (this +
            " used Fireball on " + other + " for " +
            damage + " damage!");
    }

    public String specialAttack(Damageable other){
	     if(getMana() >= 10){
  	        int damage = (int)(Math.random()*30)+10;
            other.applyDamage(damage);
            setMana(0);
            return (
            this + " unleashed the spirits of fire on "
             + other + " for " + damage + " damage! \n");
	    }
      else{
			    return ("Not enough mana! ") + attack(other);
	    }
    }

    //get methods

    public int getMana(){
	     return mana;
    }

    //set methods
    public void setMana(int r){
	     this.mana = r;
    }

    public void setWarcry(String warcry){
	     this.warcry = warcry;
    }

    public String getSpecialName(){
      return "Mana";
    }
    public int getSpecialMax(){
      return manaMax;
    }
    public int getSpecial(){
      return mana;
    }

}
