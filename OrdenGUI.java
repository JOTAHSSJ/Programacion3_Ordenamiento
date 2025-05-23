import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrdenGUI {
    private JPanel pGeneral;
    private JComboBox comboBox1;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JButton ordenarButton;

    int [] arregloID= new int[20];

    public OrdenGUI() {

        ordenarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBox1.getSelectedIndex()==0){
                    textArea1.setText("");
                    textArea2.setText("");
                    burbuja();
                }
                if (comboBox1.getSelectedIndex()==1){
                    textArea1.setText("");
                    textArea2.setText("");
                    selection();
                }
                if (comboBox1.getSelectedIndex()==2){
                    textArea1.setText("");
                    textArea2.setText("");
                    insertion();
                }
            }
        });
    }

    public static int aleatorio(int max, int min){
        int num = (int) (Math.round(Math.random()*(max-min)))+min;
        return num;

    }

    //Metodo Bubble Sort
    public int bubbleSort (int []arr){
        int n= arr.length;
        int iteraciones=0;
        for (int i=0; i<n-1;i++){
            for (int j=0; j<n-i-1; j++){
                iteraciones++;
                if(arr[j]>arr[j+1]){
                    int temp= arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return iteraciones;
    }

    public void burbuja(){
        int tam= arregloID.length;
        for (int i=0; i<tam; i++){
            arregloID[i]= aleatorio(255,1);
        }

        //Arreglo Desordenado
        for (int i=0; i<tam; i++){
            textArea1.append("\n"+arregloID[i]);
        }
        JOptionPane.showMessageDialog(null,"Arreglo de: "+tam +"datos");
        int iteraciones= bubbleSort(arregloID);

        //Ordenado
        for (int i=0; i<tam; i++){
            textArea2.append("\n"+arregloID[i]);
        }
        JOptionPane.showMessageDialog(null,"Iteraciones: "+iteraciones);
    }


    //Metodo Selection Sort
    public int selectionSort (int []arr){
        int n= arr.length;
        int iteraciones=0;
        for (int i=0; i<n-1; i++){
            int minIdx = i;
            for (int j=i+1; j<n; j++){
                iteraciones++;
                if(arr[j] < arr[minIdx]){
                    minIdx=j;
                }
            }
            int temp= arr[minIdx];
            arr[minIdx]=arr[i];
            arr[i]=temp;
        }
        return iteraciones;
    }

    public void selection(){
        int tam= arregloID.length;
        for (int i=0; i<tam; i++){
            arregloID[i]= aleatorio(255,1);
        }

        //Arreglo Desordenado
        for (int i=0; i<tam; i++){
            textArea1.append("\n"+arregloID[i]);
        }
        JOptionPane.showMessageDialog(null,"Arreglo de: "+tam +"datos");
        int iteraciones= selectionSort(arregloID);

        //Ordenado
        for (int i=0; i<tam; i++){
            textArea2.append("\n"+arregloID[i]);
        }
        JOptionPane.showMessageDialog(null,"Iteraciones: "+iteraciones);
    }

    //Metodo insection Sort
    public int insertionSort (int []arr){
        int n= arr.length;
        int iteraciones=0;
        for (int i=1; i<n; ++i){
            int key= arr[i];
            int j= i-1;

            //Desplazar los elementos que sean mayores key
            while (j>=0 && arr[j] > key){
                arr[j+1]= arr[j];
                j= j-1;
                iteraciones++;
            }
            arr[j+1]= key;
            iteraciones++;
        }
        return iteraciones;
    }
    public void insertion(){
        int tam= arregloID.length;
        for (int i=0; i<tam; i++){
            arregloID[i]= aleatorio(255,1);
        }

        //Arreglo Desordenado
        for (int i=0; i<tam; i++){
            textArea1.append("\n"+arregloID[i]);
        }
        JOptionPane.showMessageDialog(null,"Arreglo de: "+tam +"datos");
        int iteraciones= insertionSort(arregloID);

        //Ordenado
        for (int i=0; i<tam; i++){
            textArea2.append("\n"+arregloID[i]);
        }
        JOptionPane.showMessageDialog(null,"Iteraciones: "+iteraciones);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("OrdenGUI");
        frame.setContentPane(new OrdenGUI().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
