package tn.esprit.pidevLevio.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Projet implements Serializable {

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
		private String titre;
		private String description;
		
		@ManyToOne
		private Client client;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getTitre() {
			return titre;
		}

		public void setTitre(String titre) {
			this.titre = titre;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Client getClient() {
			return client;
		}

		public void setClient(Client client) {
			this.client = client;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((client == null) ? 0 : client.hashCode());
			result = prime * result + ((description == null) ? 0 : description.hashCode());
			result = prime * result + id;
			result = prime * result + ((titre == null) ? 0 : titre.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Projet other = (Projet) obj;
			if (client == null) {
				if (other.client != null)
					return false;
			} else if (!client.equals(other.client))
				return false;
			if (description == null) {
				if (other.description != null)
					return false;
			} else if (!description.equals(other.description))
				return false;
			if (id != other.id)
				return false;
			if (titre == null) {
				if (other.titre != null)
					return false;
			} else if (!titre.equals(other.titre))
				return false;
			return true;
		}

		public Projet(int id, String titre, String description, Client client) {
			super();
			this.id = id;
			this.titre = titre;
			this.description = description;
			this.client = client;
		}

		public Projet() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
		
}
