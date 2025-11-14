# K3s Installation

# On Raspberry set raspi specific settings
On Raspberry Pi's append the following key value pairs on the end of the line

### /boot/firmware/cmdline.txt
```bash
cgroup_memory=1 cgroup_enable=memory
```

## Run Installation Script for K3s
```vim /boot/firmware/cmdline.txt
curl -sfL https://get.k3s.io | sh - 
```

## Troubleshooting
It is possible, that the downloaded script is faulty if this is the case run the following command.

```bash
sudo rm -rf /usr/local/bin/kubectl /usr/local/bin/crictl /usr/local/bin/ctr
/usr/local/bin/k3s-uninstall.sh
```

## Start & enable autostart K3s 
```bash
sudo systemctl start k3s.service
sudo systemctl enable k3s.service
``` 

## Retrieve Node Information
```bash
kubectl get nodes
```

## Permission to read k3s.yaml
```bash
sudo chmod 440 k3s.yaml
sudo chown root:$USER k3s.yaml 
```

## Copy kubeconfig to remote Host
```
sudo scp /etc/rancher/k3s/k3s.yaml remoteuser:remotehost:~/.kube/config
```
## On Remote Host change localhost Address to Raspberry Pi's Ip adress

### RemoteHost  ~/.kube/config
```
apiVersion: v1
clusters:
- cluster:
    certificate-authority-data: 
    xxx
    server: https://127.0.0.1:6443 <== Change this to K3s Nodes Ip Adress
  name: default
contexts:
- context:
    cluster: default
    user: default
  name: default
current-context: default
kind: Config
preferences: {}
users:
- name: default
  user:
    client-certificate-data: 
    xxx
```
---
#### Further Documentations:
[K3s Installation Docu](https://docs.k3s.io/installation)


# Install Headlamp K8s Dashboard
```bash
kubectl apply -f ./dashboard/headlamp.yaml
```
## Create Service Account & Give Admin rights
```bash
kubectl -n kube-system create serviceaccount headlamp-admin
kubectl create clusterrolebinding headlamp-admin --serviceaccount=kube-system:headlamp-admin --clusterrole=cluster-admin
```
## Generate Token for Login
```bash
kubectl create token headlamp-admin -n kube-system
```

