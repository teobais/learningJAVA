public class hanoi {
  public static void printUsage(Runtime runtime) {
    long total, free, used;

    total = runtime.totalMemory();
    free  = runtime.freeMemory();
    used = total - free;

    System.out.println("\nTotal Memory: " + total);
    System.out.println("        Used: " + used);
    System.out.println("        Free: " + free);
    System.out.println("Percent Used: " + ((double)used/(double)total)*100);
    System.out.println("Percent Free: " + ((double)free/(double)total)*100);
  }

  public static final void main(String[] args) {
    Runtime runtime;
    byte[] bytes;

    // Print initial memory usage.
    runtime = Runtime.getRuntime();
    printUsage(runtime);

    // Allocate a 1 Megabyte and print memory usage
    bytes = new byte[1024*1024];
    printUsage(runtime);

    bytes = null;
    // Invoke garbage collector to reclaim the allocated memory.
    runtime.gc();

    // Wait 5 seconds to give garbage collector a chance to run
    try {
      Thread.sleep(5000);
    } catch(InterruptedException e) {
      e.printStackTrace();
      return;
    }

    // Total memory will probably be the same as the second printUsage call,
    // but the free memory should be about 1 Megabyte larger if garbage
    // collection kicked in.
    printUsage(runtime);
  }
}