public class OrbList {
  OrbNode first, last;

  //create a fixed orb
  OrbList() {
    first = new FixedOrbNode(0, height/5);
    last = new FixedOrbNode(width, height/5);
    //link them to eachother
    first.next = last;
    last.prev = first;
  }

  /**
   *complete this method
   */
  void add(OrbNode orb) {
    //insert orb at the end of the list before the last node.

    //OrbNode before = last.prev;
    //orb.next = last;
    //last.prev = orb;
    //orb.prev = before;
    if (last.prev.prev == null) {
      orb.next = last;
      last.prev = orb;
      orb.prev = first;
      first.next = orb;
    } else {
      OrbNode before = last.prev;
      orb.next = last;
      last.prev = orb;
      orb.prev = before;
      before.next = orb;
    }
  }

  void add(int xcor, OrbNode toBeAdded) {
    OrbNode current = first;
    while (current.x <= xcor) {
      current = current.next;
    }
    OrbNode before = current.prev;
    toBeAdded.next = current;
    toBeAdded.prev = before;
    current.prev = toBeAdded;
    before.next = toBeAdded;
  }

  void delete(OrbNode target) {
    if (target != null) {
      target.prev.next = target.next;
      target.next.prev = target.prev;
      target = null;

    }
  }

  OrbNode getNodeAt(int x, int y) {
    OrbNode current = first;
    while (current != last) {
      if (dist(current.x, current.y, x, y) <= 30) {
        return current;
      }
      current = current.next;
    }
    return null;
  }

  /**
   *complete this method
   *process all nodes by running move.
   */
  void processAll() {
    OrbNode current = first;
    //advance current to next until it is null, move() each of the nodes
    while (current != null) {
      current.move();
      current = current.next;
    }
  }
  /**
   *complete this method
   *Display all nodes by running their display().
   */
  void display() {
    OrbNode current = first;
    //advance current to next until it is null, display() each of the nodes
    while (current != null) {
      current.display();
      current = current.next;
    }
  }
}
