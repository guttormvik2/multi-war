# multi-war

This is a sample project to build an ear containing multiple vaadin20+ wars.
This is useful if you want your wars to have separate security contexts.

## Modules

* ear - The main deliverable
* one - A vaadin war
* two - A vaadin war
* widgetset - The vaadin client-side, and where you put any themes

one and two are both based on the plain java starter from https://vaadin.com/hello-world-starters


## Issues

There are two issues with getting vaadin20+ to run in a multi-war configuration

### Dev mode

The vaadin dev environment has a special setup:
When you change java files, your ide will automatically update the class in the running application
When you change frontend files however, your IDE has no idea it needs to do anything.
Here, Vaadin has some extra magic to ensure that any changes you do to files in frontend are made available to the running app.
This depends on the running application to connect back to the correct source directory, and this fails when you have frontend in multiple places.
This is fixed by separating the frontend out into a separate "widgetset" jar

Note: One of the uses of frontend is for themes. I believe it should work with this setup, as long as you place them in widgetset\frontend\themes, but currently I don't use them.
I put the css and images as regular files in one\src\main\webapp


### Skinnywar

When building a multi-war application, you don't want to let each war contain all of its dependencies.
You want all shared dependencies to be, well, shared. This reduces the total size of the application.
The standard solution to this is to use "skinnywar", where the wars say the dependency is provided, and the ear has it instead.

Some of these shared dependencies are the vaadin libraries themselves.
In earlier versions of Vaadin, I had problems getting this to work, since Vaadin looked up stuff relative to its own classloader.
When Vaadin was in ear\lib, it could not see the things in one and two.

With the current setup it seems to work just fine; vaadin-core and all its dependencies are in ear\lib
