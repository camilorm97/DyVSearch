public class binary_search {


    // Búsqueda tradicional
    public static boolean search(int[] lista, int n_search) {

        boolean is_found = false;
        int cont = 0;

        while (!is_found && cont < lista.length) {
            if (lista[cont] == n_search)
                is_found = true;
            cont++;
        }

        return is_found;
    }

    public static int search_DyV(int[] lista, int init, int end, int n_search) {
        if (lista.length == 0 || init > end)
            return -1;
        else {
            int middle = (init + end) / 2;

            if (n_search == lista[middle])
                return middle;

            else {
                if (n_search < lista[middle])
                    return search_DyV(lista, init, middle - 1, n_search);
                else
                    return search_DyV(lista, middle + 1, end, n_search);
            }
        }
    }

    public static void main(String[] args) {
        int[] lista = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int n_search = 6;
        int n_pos = search_DyV(lista, 0, lista.length - 1, n_search);

        if (n_pos == -1)
            System.out.println("No se ha encontrado el número que buscas");
        else
            System.out.println("El número que buscas '" + lista[n_pos] + "' se encuentra en la posición :" + n_pos);
    }

}
