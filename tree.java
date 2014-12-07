public class tree {

	Data root;

	boolean isEmpty() {
	return root == null;
	}

	void insert(Data tmp) {
		if (isEmpty()) {
			root = tmp;
		} else {
			Data current = root;
			Data parent = null;
			boolean diKiri = true;
			while (current != null) {
				parent = current;
				if (current.kata.compareTo(tmp.kata) < 0) {
					current = current.kanan;
					diKiri = false;
				} else {
					current = current.kiri;
					diKiri = true;
				}
			}
			if (diKiri) {
				parent.kiri = tmp;
			} else {
				parent.kanan = tmp;
			}
		}
	}

	void traverse(Data d, String prefix) {
		if (d != null) {
			if (d.kata.startsWith(prefix)){
				System.out.println(" - " + d.kata + "\t\t\t"+d.makna);
				this.traverse(d.kanan, prefix);
			}
			this.traverse(d.kiri, prefix);
		}
	}

	void search(String cari) {
		cari = cari.toLowerCase().trim();
		Data current = root;
		while (current != null) {
			if (current.kata.startsWith(cari)) {
				this.traverse(current, cari);
				break;
			} else {
				if (current.kata.compareTo(cari) < 0) {
					current = current.kanan;
				} else {
					current = current.kiri;
				}
			}
		}
	}
}
