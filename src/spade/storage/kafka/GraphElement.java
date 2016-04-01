/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package spade.storage.kafka;  
@SuppressWarnings("all")
/** A generic object which can be either a vertex or an edge */
@org.apache.avro.specific.AvroGenerated
public class GraphElement extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"GraphElement\",\"namespace\":\"spade.storage.kafka\",\"doc\":\"A generic object which can be either a vertex or an edge\",\"fields\":[{\"name\":\"element\",\"type\":[{\"type\":\"record\",\"name\":\"Edge\",\"fields\":[{\"name\":\"annotations\",\"type\":[\"null\",{\"type\":\"map\",\"values\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"avro.java.string\":\"String\"}]},{\"name\":\"sourceVertexHash\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"destinationVertexHash\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"hash\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]},{\"type\":\"record\",\"name\":\"Vertex\",\"fields\":[{\"name\":\"annotations\",\"type\":[\"null\",{\"type\":\"map\",\"values\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"avro.java.string\":\"String\"}]},{\"name\":\"hash\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]}]}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.Object element;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public GraphElement() {}

  /**
   * All-args constructor.
   */
  public GraphElement(java.lang.Object element) {
    this.element = element;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return element;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: element = (java.lang.Object)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'element' field.
   */
  public java.lang.Object getElement() {
    return element;
  }

  /**
   * Sets the value of the 'element' field.
   * @param value the value to set.
   */
  public void setElement(java.lang.Object value) {
    this.element = value;
  }

  /** Creates a new GraphElement RecordBuilder */
  public static spade.storage.kafka.GraphElement.Builder newBuilder() {
    return new spade.storage.kafka.GraphElement.Builder();
  }
  
  /** Creates a new GraphElement RecordBuilder by copying an existing Builder */
  public static spade.storage.kafka.GraphElement.Builder newBuilder(spade.storage.kafka.GraphElement.Builder other) {
    return new spade.storage.kafka.GraphElement.Builder(other);
  }
  
  /** Creates a new GraphElement RecordBuilder by copying an existing GraphElement instance */
  public static spade.storage.kafka.GraphElement.Builder newBuilder(spade.storage.kafka.GraphElement other) {
    return new spade.storage.kafka.GraphElement.Builder(other);
  }
  
  /**
   * RecordBuilder for GraphElement instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<GraphElement>
    implements org.apache.avro.data.RecordBuilder<GraphElement> {

    private java.lang.Object element;

    /** Creates a new Builder */
    private Builder() {
      super(spade.storage.kafka.GraphElement.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(spade.storage.kafka.GraphElement.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.element)) {
        this.element = data().deepCopy(fields()[0].schema(), other.element);
        fieldSetFlags()[0] = true;
      }
    }
    
    /** Creates a Builder by copying an existing GraphElement instance */
    private Builder(spade.storage.kafka.GraphElement other) {
            super(spade.storage.kafka.GraphElement.SCHEMA$);
      if (isValidValue(fields()[0], other.element)) {
        this.element = data().deepCopy(fields()[0].schema(), other.element);
        fieldSetFlags()[0] = true;
      }
    }

    /** Gets the value of the 'element' field */
    public java.lang.Object getElement() {
      return element;
    }
    
    /** Sets the value of the 'element' field */
    public spade.storage.kafka.GraphElement.Builder setElement(java.lang.Object value) {
      validate(fields()[0], value);
      this.element = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'element' field has been set */
    public boolean hasElement() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'element' field */
    public spade.storage.kafka.GraphElement.Builder clearElement() {
      element = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    @Override
    public GraphElement build() {
      try {
        GraphElement record = new GraphElement();
        record.element = fieldSetFlags()[0] ? this.element : (java.lang.Object) defaultValue(fields()[0]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
