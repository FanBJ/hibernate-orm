/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * Copyright (c) 2011, Red Hat Inc. or third-party contributors as
 * indicated by the @author tags or express copyright attribution
 * statements applied by the authors.  All third-party contributions are
 * distributed under license by Red Hat Inc.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 */
package org.hibernate.metamodel.spi.binding;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.internal.FilterConfiguration;

/**
 * Describes plural attributes of {@link org.hibernate.metamodel.spi.binding.PluralAttributeElementBinding.Nature#MANY_TO_MANY} elements
 *
 * @author Steve Ebersole
 * @author Gail Badner
 */
public class ManyToManyPluralAttributeElementBinding extends AbstractPluralAttributeAssociationElementBinding implements Filterable{
	private List<FilterConfiguration> filterConfigurations = new ArrayList<FilterConfiguration>();
	private String manyToManyWhere;
	private String manyToManyOrderBy;
	private boolean fetchImmediately;
	// TODO: really should have value defined (which defines table), but may not know 
	private RelationalValueBindingContainer relationalValueBindingContainer;

	ManyToManyPluralAttributeElementBinding(AbstractPluralAttributeBinding binding) {
		super( binding );
	}

	@Override
	protected RelationalValueBindingContainer getRelationalValueContainer() {
		return relationalValueBindingContainer;
	}

	@Override
	public Nature getNature() {
		return Nature.MANY_TO_MANY;
	}

	public void setRelationalValueBindings(List<RelationalValueBinding> relationalValueBindings) {
		this.relationalValueBindingContainer = new RelationalValueBindingContainer( relationalValueBindings );
	}

	public String getManyToManyWhere() {
		return manyToManyWhere;
	}

	public void setManyToManyWhere(String manyToManyWhere) {
		this.manyToManyWhere = manyToManyWhere;
	}

	public String getManyToManyOrderBy() {
		return manyToManyOrderBy;
	}

	public void setManyToManyOrderBy(String manyToManyOrderBy) {
		this.manyToManyOrderBy = manyToManyOrderBy;
	}

	public boolean fetchImmediately() {
		return fetchImmediately;
	}

	public void setFetchImmediately(boolean fetchImmediately) {
		this.fetchImmediately = fetchImmediately;
	}
	@Override
	public void addFilterConfiguration(FilterConfiguration filterConfiguration) {
		filterConfigurations.add( filterConfiguration );
	}

	@Override
	public List<FilterConfiguration> getFilterConfigurations() {
		return filterConfigurations;
	}
}
