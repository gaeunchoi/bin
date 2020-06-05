import java.util.ArrayList;

public class NextFit implements Fit{
    @Override
    public void fit(ArrayList<Bin> arr, Item item) {
        Bin bin = new Bin();
        if(arr.size() == 0){
            bin.update(item);
            arr.add(bin);
        }
        else {
            bin = arr.get((arr.size())-1);

            if(bin.check(item))
                bin.update(item);
            else {
                Bin b = new Bin();
                b.update(item);
                arr.add(b);
            }
        }

    }
}
