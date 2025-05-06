package com.ait.service;

import com.ait.model.Conversion;

public interface Converter {
    Conversion convert(String from, String to, double amount);
}
