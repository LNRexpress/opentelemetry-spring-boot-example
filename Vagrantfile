# -*- mode: ruby -*-
# vi: set ft=ruby :

Vagrant.configure("2") do |config|
    config.vm.box = "debian/bookworm64"

    # Create a private network, which allows host-only access to the machine
    # using a specific IP.
    config.vm.network "private_network", ip: "192.168.0.100"

    config.vm.provider "virtualbox" do |vb|
      vb.gui = false
      vb.memory = "4096"
      vb.cpus = 4
    end

    config.vm.provision "shell", path: "vagrant/bootstrap-common.sh"
    config.vm.provision "shell", path: "vagrant/create-swap.sh"
    config.vm.provision "shell", path: "vagrant/bootstrap-k3s.sh"
    config.vm.provision "shell", path: "vagrant/bootstrap-opentelemetry.sh"
    config.vm.provision "shell", path: "vagrant/bootstrap-buildah.sh"
  end
