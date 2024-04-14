public class Demo {

  public static void main(String args[]){
  SuperArray alist = new SuperArray();
  System.out.println(alist);
  alist.add("Mario");
  //displaying elements
  System.out.println(alist);
  System.out.println(alist.toStringDebug());

  alist.add("Samus");
  //displaying elements
  System.out.println(alist);
  System.out.println(alist.toStringDebug());

  alist.add("Ash");
  alist.add("Link");
  alist.add("Kirby");
  //displaying elements
  System.out.println(alist);
  System.out.println(alist.toStringDebug());

  // System.out.println(alist.get(2));
  // System.out.println(alist.get(4));
  // System.out.println(alist.set(4, "Zelda"));
  // System.out.println(alist.get(4));
  // System.out.println(alist);
  // for (int i = 0; i < alist.size(); i++) {
  //   System.out.println(alist.get(i));
  // }

  for (int i = 0; i <= alist.size(); i++) {
    alist.set(i, alist.get(i+1));
    if (i == alist.size()-1) {
      alist.set(i, "NOPE!");
    }
  }
  System.out.println(alist);
  SuperArray blist = new SuperArray(3);
  System.out.println(blist.toStringDebug());
  blist.add("Ash");
  blist.add("Link");
  blist.add("Kirby");
  System.out.println(blist);
  System.out.println(blist.toStringDebug());
  blist.add("Kirby");
  System.out.println(blist.toStringDebug());
  System.out.println(blist.indexOf("Kirby"));
  System.out.println(blist.lastIndexOf("Kirby"));
  blist.add(4, "a");
  System.out.println(blist.toString());
  System.out.println(blist.toStringDebug());
  blist.add(5, "a");
  System.out.println(blist.toStringDebug());
  blist.add(6, "a");
  System.out.println(blist.toStringDebug());
  blist.add(7, "a");
  System.out.println(blist.toStringDebug());
  blist.add(0, "a");
  System.out.println(blist.toStringDebug());
  blist.add(3, "a");
  System.out.println(blist.toStringDebug());
  blist.remove(3);
  System.out.println(blist.toStringDebug());
  blist.remove("a");
  System.out.println(blist.toStringDebug());
  blist.remove("a");
  System.out.println(blist.toStringDebug());
  blist.remove("a");
  System.out.println(blist.toStringDebug());
  blist.remove("a");
  System.out.println(blist.toString());
}

}
