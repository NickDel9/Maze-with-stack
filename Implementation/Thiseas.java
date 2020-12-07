
import java.io.*;
import java.io.IOException;



public class Thiseas {


    Boolean[][] visited;
    String[][] array;
    int rows , columns ;
    StringStackImpl<Point<Integer>> stack = new StringStackImpl<>();


    public Thiseas(String file)
    {
        readFile(file);
    }

    private boolean Has0(int x, int y)
    {
        return this.array[x][y].equals("0");
    }

    private void setVisited()
    {
        this.visited = new Boolean[this.rows][this.columns];
        for (int i =0 ; i<this.rows; i++){
            for (int j = 0; j< this.columns ; j++)
            {
                this.visited[i][j] = true;
            }
        }
    }

    private boolean maze(int x , int y)
    {
        setVisited();

        stack.push(new Point<Integer>(x,y));

        Point<Integer> temp ;

        while (!this.stack.isEmpty())
        {
            temp = this.stack.peek();
            int direction = temp.getDirection();
            x = temp.getX();
            y = temp.getY();

            temp.setDirection(temp.getDirection()+1);
            this.stack.pop();
            this.stack.push(temp);

            if ((this.stack.peek().getX() == this.rows-1 || this.stack.peek().getX() == 0 || this.stack.peek().getY() == this.columns-1 || this.stack.peek().getY() == 0)
                    && this.Has0(this.stack.peek().getX(),this.stack.peek().getY())){
                        return true;
            }

            if (direction == 0){
                if (x - 1 >= 0 && this.array[x - 1][y].equals("0") && this.visited[x-1][y]){
                    Point<Integer> temp1 = new Point<>(x - 1, y);
                    this.visited[x-1][y] = false;
                    this.stack.push(temp1);
                    System.out.println("Goes up " + this.stack.peek().getX() +" " + this.stack.peek().getY());
                }
            }
            else if (direction == 1){
                if (y - 1 >= 0 && this.array[x][y - 1].equals("0") && this.visited[x][y-1]){
                    Point<Integer> temp1 = new Point<>(x , y - 1);
                    this.visited[x][y-1] = false;
                    this.stack.push(temp1);
                    System.out.println("Goes left " + this.stack.peek().getX() +" " + this.stack.peek().getY());
                }
            }
            else if (direction == 2){
                if (x + 1 < this.rows && this.array[x + 1][y].equals("0") && this.visited[x+1][y]){
                    Point<Integer> temp1 = new Point<>(x + 1, y);
                    this.visited[x+1][y] = false;
                    this.stack.push(temp1);
                    System.out.println("Goes down " + this.stack.peek().getX() +" " + this.stack.peek().getY());
                }
            }
            else if (direction == 3){
                if (y + 1 < this.columns && this.array[x][y+1].equals("0") && this.visited[x][y+1]){
                    Point<Integer> temp1 = new Point<>(x , y + 1);
                    this.visited[x][y+1] = false;
                    this.stack.push(temp1);
                    System.out.println("Goes right " + this.stack.peek().getX() +" " + stack.peek().getY());
                }
            }
            else{
                this.visited[temp.getX()][temp.getY()] = true;
                this.stack.pop();
            }
        }
        return false;
    }

    private boolean epsilon(){
         int E = 0;
         for (int i=0;i<this.rows;i++){
             for (int j=0;j<this.columns;j++) {
                 if (this.array[i][j].equals("E")) {
                     E++;
                 }
             }
         }
        return E == 1;
    }


    private void readFile(String file)
    {
        int p = 0 , s = 0;
        String line;
        String[][] arr1 = {};
        String[] arr = new String[2];
        int Rows = 0; int Columns = 0;
        int SintX =0; int SintY = 0;
        int i = 0;
        boolean WrongInputTxt = false;
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null && !WrongInputTxt ) {
                System.out.println(line);
                if (line.length() == 3 && i == 0) {
                    arr[i] = line;;
                    Rows = Integer.parseInt(String.valueOf(arr[i].charAt(0)));
                    Columns = Integer.parseInt(String.valueOf(arr[i].charAt(2)));
                } else if (line.length() == 3 && i == 1) {
                    arr[i] = line;
                    SintX = Integer.parseInt(String.valueOf(arr[i].charAt(0)));
                    SintY = Integer.parseInt(String.valueOf(arr[i].charAt(2)));
                } else if ((line.length() != 3) && (i <= 1)) {
                    System.out.print("Wrong input file.");
                    WrongInputTxt = true;
                }
                  else if ((line.length() == Columns + Columns - 1) && (i > 1)) {
                    if (i == 2) {
                        arr1 = new String[Rows][Columns];
                    }
                        for (int j = 0; j < Columns + Columns - 1; j++) {
                            if (!String.valueOf(line.charAt(j)).equals(" ")) {
                                String stoixeio = String.valueOf(line.charAt(j));
                                if (p == Columns) {
                                    p = 0;
                                }
                                arr1[s][p] = stoixeio;
                            p++;
                            }
                        }
                        s++;
                 }
                i++;
            }
            if (!WrongInputTxt)
            {
                this.rows = Rows;
                this.columns = Columns;
                this.array = new String[this.rows ][this.columns];
                for (int r = 0 ; r <this.rows ; r++ ){
                    if (this.columns >= 0) System.arraycopy(arr1[r], 0, this.array[r], 0, this.columns);
                }
                if (this.epsilon())
                {
                    if(this.maze(SintX, SintY))
                        System.out.println("Exit ! ");
                    else
                        System.out.println("no exit .");
                } else
                    System.out.print("Wrong entry position.");
            }
            bufferedReader.close();
        }
                catch(FileNotFoundException ex){
                    System.out.println(
                            "Unable to open file '" + file + "'");
                }
                 catch(IOException ex) {
                    System.out.println(
                            "Error reading file '"
                                    + file + "'");
                }
    }

        public static void main(String[] args) throws IOException
        {
            new Thiseas(args[0]);
        }
    }