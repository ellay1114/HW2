package il.ac.tau.cs.software1.inventory;

/*
 * A simple array-based Inventory (Question 6).
 */
public class NaiveInventory implements Inventory {

    private static final int INITIAL_CAPACITY = 100;
    private Collectible[] storedItems;
    private int storedCounter;

    public NaiveInventory() {
        // An array of Collectibles
        storedCounter = 0;
        // An int that counts how many items are actually stored
        storedItems = new Collectible[INITIAL_CAPACITY];
    }

    @Override
    public void collect(Collectible collectible) {
        if (storedCounter >= storedItems.length) {
            // Enlarge the stored items array
            Collectible[] newArray = new Collectible[2 * storedItems.length];
            System.arraycopy(storedItems, 0, newArray, 0, storedCounter);
            storedItems = newArray;
        }

        storedItems[storedCounter] = collectible;
        storedCounter++;
    }

    @Override
    public float getTotalWeight() {
		float weight = 0.f;

		for (int i = 0; i < storedCounter; i++) {
			weight += storedItems[i].getWeight();
		}

		return weight;
    }

    @Override
    public int getCurrentCount() {
        return storedCounter;
    }

    // Returns the array of Collectibles that is stored in the field of this class
    public Collectible[] getCollArr() {
        return storedItems;
    }
}
