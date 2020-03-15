enum GrauParentesco{
    CONJUGE, FILHO, PAI
}
class Dependente {
    private String nome;
    private GrauParentesco grauParentesco;

    public Dependente(String nome, GrauParentesco grauParentesco) {
        this.nome = nome;
        this.grauParentesco = grauParentesco;
    }

    public String getNome() {
        return nome;
    }

    public String getGrauParentesco() {
        switch (grauParentesco){
            case PAI: return "Pai/Mãe";
            case FILHO: return "Filha/o";
            case CONJUGE: return "Conjuge";
        }
        return null;
    }

    @Override
    public String toString() {
        return this.getNome() + " " + this.getGrauParentesco();
    }
}
interface Iterator{
    public void first();
    public void next();
    public boolean isDone();
    public Object currentItem();
    public int getIndex();
    public byte getLength();
}

class IteratorImpl <T> implements Iterator{
    private T [] itens;
    private int index;

    public IteratorImpl(T[] itens) {
        this.itens = itens;
    }


    @Override
    public void first() {
        index = 0;
    }

    @Override
    public void next() {
        index++;
    }

    @Override
    public boolean isDone() {
        return index == itens.length;
    }

    @Override
    public T currentItem() {
        return itens[index];
    }

    @Override
    public int getIndex() {
        return index;
    }

    @Override
    public byte getLength() {
        return (byte)itens.length;
    }
}

class AcoesParaDependentes{
    private Dependente [] lstDependente;

    public void adicionar(Dependente dependente){
        byte pos = 0;
        if (lstDependente == null){
            lstDependente = new Dependente[1];
        }else{
            IteratorImpl<Dependente> backup =
                    new IteratorImpl<Dependente>(lstDependente);
            lstDependente = new Dependente[lstDependente.length+1];
            for (backup.first(); !backup.isDone(); backup.next())
                lstDependente[backup.getIndex()] = backup.currentItem();
            pos = (byte) backup.getLength();
        }
        lstDependente[pos] = dependente;
    }
    public void remover(byte posicao){
        if (lstDependente.length == 1){
            lstDependente = null;
        } else {
            IteratorImpl<Dependente> backup =
                    new IteratorImpl<Dependente>(lstDependente);
            lstDependente = new Dependente[lstDependente.length-1];
            byte j = 0;
            for (backup.first(); !backup.isDone(); backup.next())
                if (backup.getIndex() != posicao)
                        lstDependente[j++] = backup.currentItem();
        }
    }
    public void listar(){
        if (lstDependente != null){
            IteratorImpl<Dependente> backup =
                    new IteratorImpl<Dependente>(lstDependente);
            System.out.println("Dependetes de funcionario: ");
            for (backup.first(); !backup.isDone(); backup.next()){
                System.out.println("- " + backup.currentItem());
            }
        }
    }
}
public class Iter {
}
