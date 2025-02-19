
public class ArrayList {

    private Integer[] array;
    /**
     * indice do ultimo elemento
     */
    private Integer last; 
   
    public ArrayList(int capacidadeInicial) {
        array = new Integer[capacidadeInicial];
        last = -1;
    }

    public boolean isEmpty() {
        return array.length == 0;
    }

   private boolean isFull(){
      return this.size() == this.array.length;
   }
      
   public void addFirst(int valor) {
        //if ()
        
        //resize();
        //shiftRight();
        array[0] = valor;
    }

   public void addLast(int valor) {
      if (this.isFull())
         resize(this.array.length*2);
   
      array[++last] = valor;
   }

   // adiciona um valor no índice passado como parâmetro
   public void add(int index, int valor) {
      
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
        // TODO
        return -1;
    }

    // deve lançar exceção caso a fila esteja vazia.
    public int removeFirst() {
        // TODO 
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
        
        //shifLeft(array, index);
        last--;
    }

    // remove a primeira ocorrência do elemento cujo valor foi passado como parâmetro.
    // se não encontrar, não faça nada.
    public void removeByValue(int value) {
      
      
      for (int i = 0; i < size(); i++) {
         if (array[i] == value){
            remove(i);
            break;
         }
         
      }
    }

    // retorna o índice da primeira ocorrência do valor passado como parâmetro.
    public int indexOf(int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value)
                return i;
        }
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
            output += " ";

      return output;
    }
    
    public int size() {
        int tam = 0;
        
        for (int i = 0; i < last; i++)
           tam++;
        return tam;
    }
}
