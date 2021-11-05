package Structuraldesignpatterns.proxy

class ProxyPicker(private val picker: IPicker) : IPicker by picker
