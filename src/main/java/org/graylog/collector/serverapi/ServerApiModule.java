/**
 * This file is part of Graylog.
 *
 * Graylog is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Graylog is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Graylog.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.graylog.collector.serverapi;

import org.graylog.collector.annotations.GraylogServerURL;
import org.graylog.collector.guice.CollectorModule;
import retrofit.RestAdapter;

public class ServerApiModule extends CollectorModule {
    @Override
    protected void configure() {
        bind(String.class).annotatedWith(GraylogServerURL.class).toProvider(ServerURLProvider.class);
        bind(RestAdapter.class).toProvider(RestAdapterProvider.class).asEagerSingleton();
    }
}
