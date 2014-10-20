RedDeer Quickstart
==================

Prerequisite
------------

* Java 7 or higher
* Maven 3.0.5 or higher
* Another DISPLAY, eg. using vnc, xephyr,...
* Eclipse IDE with RedDeer 0.6.0

RedDeer
-------

* [https://github.com/jboss-reddeer/reddeer](https://github.com/jboss-reddeer/reddeer)
* [http://download.jboss.org/jbosstools/updates/stable/luna/core/reddeer/0.6.0] (http://download.jboss.org/jbosstools/updates/stable/luna/core/reddeer/0.6.0)

First Execution
---------------

    sudo yum install tigervnc, tigervnc-server
    vncpasswd    
    vncserver :2 -geometry
    vncviewer :2
    DISPLAY=:2 mvn clean verify

