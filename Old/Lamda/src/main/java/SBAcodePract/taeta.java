package SBAcodePract;

public class taeta {

    public static void main(String[] args){

       Cricket c = new Cricket();
       int count = 0;
       for (int i : c.playerIDs){
          // System.out.println(i);
           System.out.println(i + " is index of "  + count);
           count++;
       }






    }


    static class Cricket {
        int[] playerIDs;
        public Cricket(){
            this.playerIDs = new int[11];

            for (int i = 0; i < playerIDs.length; i++) {
                playerIDs[i] = 1;
            }


        }


    }

}
