
public class ArrayList {

   private Integer[] array;
   
   /**
    * indice do ultimo elemento
    */
   private Integer last; 

   private Integer size;
   
   public ArrayList(int capacidadeInicial) {
      array = new Integer[capacidadeInicial];
      last = -1;
      size = 0;
   }

   public boolean isEmpty() {
      return size() == 0;
   }

   private boolean isFull(){
      return this.size == this.array.length;
   }
      
   public void addFirst(int valor) {
      if (isFull())
         resize(array.length * 2);
      
      shiftRight(array, last);
      array[0] = valor;
      size++;
    }

   public void addLast(int valor) {
      if (this.isFull())
         resize(this.array.length*2);
   
      array[++last] = valor;
      size++;
   }

   // adiciona um valor no índice passado como parâmetro
   public void add(int index, int valor) {
      if (isFull())
        resize(array.length * 2);

      shiftRight(array, index);
       }

    
   // você vai precisar desse método quando tentar adicionar e a fila já estiver cheia
   private void resize(int novaCapacidade) {
   Integer[] arrayResized = new Integer[novaCapacidade];
      //System.arraycopy(array, 0, arrayResized, 0, this.array.length);
   for (int i = 0; i < this.array.length; i++) 
         arrayResized[i] = array[i];

   array = arrayResized;
   }

   public Integer[] assegureCapacidade(int capacidadePretendida) {
      return new Integer[capacidadePretendida];
   }

   public int getFirst() {
      return array[0];
   }

   public int getLast() {
      return this.array[this.last];
   }

   // retorna o elemento no índice passado como parâmetro
   // deve lançar IndexOutOfBoundsException se o índice não for válido.
   public int get(int index) {
      if (index > last || index < 0)  
         throw new IndexOutOfBoundsException("Índice inválido!");
      return array[index];
   }

   // deve lançar exceção caso a fila esteja vazia.
   public int removeFirst() {
      if (isEmpty())
         throw new ArrayIndexOutOfBoundsException("Fila vazia");
      return 0;
   }

    // deve lançar exceção caso a fila esteja vazia.
   public void removeLast() {
      if (isEmpty())
         throw new ArrayIndexOutOfBoundsException("Fila vazia");
      
      this.last--;       
   }

   // remove o valor no índice passado como parâmetro. 
   // lançar exceção se o índice não for válido.
   public void remove(int index) {
      if (isEmpty())
         throw new ArrayIndexOutOfBoundsException("Fila vazia");
      
      shifLeft(array, index);
      last--;
   }

   // remove a primeira ocorrência do elemento cujo valor foi passado como parâmetro.
   // se não encontrar, não faça nada.
   public void removeByValue(int value) {
      for (int i = 0; i < size(); i++)
         if (array[i] == value){
               remove(i);
               break;
         }
   }

   // retorna o índice da primeira ocorrência do valor passado como parâmetro.
   public int indexOf(int value) {
      for (int i = 0; i < array.length; i++)
         if (array[i] == value)
               return i;
      return -1;
   }

   // Deve retornar a posição da última ocorrência do elemento passado como parâmetro. 
   public int lastIndexOf(int valor) {
      return -1;
   }
    
   @Override
   // deve retornar uma string representando a lista. 
   public String toString() {
      String output = "";
      for (Object elem : this.array)
            output += elem + ", ";

      return output.substring(0, output.length() -2);
   }
   

   /**
    * Empurra os elementos do array para a posição do paramentro
    * @param array
    * @param index
    */
   private void shifLeft(Integer[] array, int index) {
      for (int i = index; i < last - 1; i++)
         array[i] = array[i+1];
      
      last--;

   }

   /**
    * Empurra os elementos do array para a direita a partir do index indicado
    * @param array
    * @param last
    */
   private void shiftRight(Integer[] array, Integer index) {
      for (int i = last; i > index; i++)
         array[i + 1] = array[i];
      
      last++;
   }
}
