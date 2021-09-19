package dev.hbeck.kdl.objects;

import dev.hbeck.kdl.print.PrintConfig;

import java.io.IOException;
import java.io.Writer;
import java.util.Optional;

/**
 * A model object representing the KDL 'null' value.
 */
public class KDLNull extends KDLValue<Void> {
    public KDLNull() {
        this(Optional.empty());
    }

    public KDLNull(Optional<String> type) {
        super(type);
    }

    @Override
    public Void getValue() {
        return null;
    }

    @Override
    public KDLString getAsString() {
        return new KDLString("null", type);
    }

    @Override
    public Optional<KDLNumber> getAsNumber() {
        return Optional.empty();
    }

    @Override
    public Optional<KDLBoolean> getAsBoolean() {
        return Optional.empty();
    }

    @Override
    protected void writeKDLValue(Writer writer, PrintConfig printConfig) throws IOException {
        writer.write("null");
    }

    @Override
    protected String toKDLValue() {
        return "null";
    }

    @Override
    public boolean isNull() {
        return true;
    }

    public String toString() {
        return this.getClass().getSimpleName();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof KDLNull;
    }

    public int hashCode() {
        return 0;
    }
}
