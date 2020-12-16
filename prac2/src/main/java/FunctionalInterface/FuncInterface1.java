package FunctionalInterface;

import java.io.*;
import java.util.*;

public class FuncInterface1 {


}


class  Orange{


    static int[] unuseed=new int[]{0, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 185, 186, 187, 188, 189, 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 214, 215, 216, 217, 218, 219, 220, 230, 232, 234, 237, 238, 239, 240, 241, 242, 243, 247, 248, 249, 250, 251, 252, 253, 254, 255, 256, 257, 258, 259, 260, 261, 269, 270, 271, 272, 273, 274, 275, 276, 277, 278, 279, 283, 284, 285, 286, 287, 288, 289, 290, 291, 292, 293, 294, 295, 297, 298, 299, 300, 301, 302, 303, 304, 305, 306, 307, 308, 309, 310, 311, 312, 313, 317, 327, 328, 329, 330, 331, 332, 333, 334, 335, 336, 337, 338, 339, 340, 341, 342, 343, 344, 345, 346, 347, 348, 349, 350, 351, 352, 353, 354, 355, 356, 357, 358, 359, 360, 361, 362, 363, 364, 367, 368, 370, 371, 376, 377, 381, 382, 386, 387, 388, 389, 390, 391, 392, 393, 394, 395, 396, 397, 398, 399, 400, 401, 402, 403, 404, 405, 406, 407, 408, 409, 410, 411, 412, 413, 416, 417, 418, 421, 422, 423, 424, 425, 426, 433, 434, 435, 437, 438, 442, 443, 444, 445, 446, 447, 448, 449, 450, 451, 452, 453, 454, 455, 456, 457, 458, 459, 460, 461, 462, 463, 464, 465, 466, 467, 468, 469, 470, 471, 472, 473, 474, 475, 476, 477, 478, 479, 480, 481, 482, 483, 484, 485, 486, 487, 488, 489, 490, 492, 493, 499, 506, 510, 514, 515, 516, 517, 518, 520, 538, 539, 544, 545, 546, 547, 548, 549, 550, 551, 552, 553, 554, 555, 556, 557, 558, 559, 560, 561, 562, 563, 564, 565, 566, 567, 568, 569, 570, 571, 572, 573, 574, 575, 576, 577, 578, 579, 580, 581, 582, 583, 584, 585, 586, 587, 588, 589, 590, 591, 592, 593, 594, 595, 596, 597, 599, 600, 613, 614, 623, 625, 631, 632, 635, 639, 640, 641, 642, 643, 644, 645, 646, 647, 648, 649, 650, 651, 652, 653, 654, 655, 656, 657, 658, 659, 660, 661, 662, 663, 664, 665, 666, 667, 668, 669, 670, 671, 672, 673, 690, 694, 700, 709, 715, 716, 717, 718, 719, 720, 721, 722, 723, 724, 725, 726, 727, 728, 729, 730, 731, 732, 733, 734, 735, 736, 737, 738, 739, 740, 741, 742, 743, 744, 745, 746, 747, 748, 749, 750, 751, 772, 773, 774, 775, 776, 777, 778, 779, 780, 781, 782, 783, 784, 785, 786, 787, 788, 789, 790, 791, 792, 793, 794, 795, 796, 797, 798, 799, 800, 801, 802, 803, 804, 805, 806, 807, 808, 809, 810, 811, 812, 813, 814, 818, 819, 820, 821, 822, 823, 824, 825, 826, 827, 828, 829, 830, 831, 832, 840, 841, 842, 843, 844, 845, 858, 859, 863, 871, 872, 878, 879, 880, 881, 882, 883, 884, 885, 886, 887, 888, 889, 890, 891, 892, 893, 894, 895, 896, 897, 898, 899, 900, 901, 902, 903, 904, 905, 906, 907, 908, 909, 910, 911, 914, 932, 933, 934, 935, 936, 937, 938, 939, 940, 941, 942, 950, 961, 964, 965};



    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }






    public int ref;
    public static String currentFile;
        public static  int times=0;
        public static int timesDire=0;
        static  boolean currentOne;
    public static int timesSentFile=0;
    public Orange(int ref) {
        this.ref = ref;
    }




    static int methRef(String a, Orange myOran){
        return 1;
    }

    int methRef2(String a,Orange myOran){
        return this.ref;
    }

    static  void  finalCheck(File file) throws FileNotFoundException {
            times++;
       // System.out.println(file.getName());

        try {
            File myObj=new File("C:/Users/siddh/Desktop/code/LNT_PROJECTS/Unused/"+file.getName());
            if (myObj.createNewFile()) {
                //System.out.println("File created: " + myObj.getName());
                copyFileUsingStream(file,myObj);
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


        Scanner scanner=new Scanner(file);
        int cnt=0;
        while (scanner.hasNext()) {
            String line = scanner.nextLine().toString();
            cnt++;
            //final String lineFromFile = scanner.nextLine();
           // System.out.println(line);
            if(line.contains(currentFile)) {
                // match
                    currentOne=true;

            }
        }
        System.out.println(cnt);



    }

   static  void ListFilesRecursive(String directoryName) throws FileNotFoundException {
            File directory=new File(directoryName);
            File[] flist=directory.listFiles();


            for(File file:flist){
                if(file.isFile()){
                 finalCheck(file);

                }
                else if(file.isDirectory()){
                   // System.out.println(file.getName());
                    timesDire++;
                    ListFilesRecursive(file.getAbsolutePath());
                }
            }



    }

    public static void main(String[] args) throws FileNotFoundException {
        File directoryPath = new File("C:/Users/siddh/Desktop/code/LNT_PROJECTS/LNTProj/src/test/resources/mockdata");
        File filesList[] = directoryPath.listFiles();
        List<String> names=new ArrayList<>();
        List<String> notRequired=new ArrayList<>();


        Set<Integer> hash_Set
                = new HashSet<Integer>();
        for (int i = 0; i < unuseed.length; i++) {
            hash_Set.add(unuseed[i]);
        }
        System.out.println("t    "+hash_Set.size());
        int index=0;
        for(File file : filesList) {

            String[] parts = file.getName().split("\\.");
            names.add("'"+parts[0]+"'");
            currentFile=file.getName();
            //System.out.println(file.getAbsolutePath());
            //ListFilesRecursive("C:/Users/siddh/Desktop/code/LNT_PROJECTS/LNTProj/src/test/java/com/mtvi");

            if(hash_Set.contains(index)){
                //for printing the file name
               // System.out.println(file.getName());

                //for changing names of the files
                File oldName =
                        new File(file.getAbsolutePath());
                File newName =
                        new File(file.getAbsolutePath()+".unused");

                if (oldName.renameTo(newName))
                    System.out.println("Renamed successfully");
                else
                    System.out.println("Error");
            }
            index++;


        }

        System.out.println("imp " +names.size());
        //ListFilesRecursive("C:/Users/siddh/Desktop/code/LNT_PROJECTS/LNTProj/src/test/java/com/mtvi");

        System.out.println(names.size() +"  "+ notRequired.size() );

        System.out.println(times+" "+timesDire);

    }


}

interface two{
    int test(String a,Orange o);
}
